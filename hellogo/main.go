package main

import (
	"log"
	"net/http"
	"sync"

	"github.com/gorilla/websocket"
)

var upgrader = websocket.Upgrader{
	CheckOrigin: func(r *http.Request) bool {
		return true
	},
}

var clients = make(map[*websocket.Conn]bool)
var mutex = sync.Mutex{}

func handleWS(w http.ResponseWriter, r *http.Request) {
	conn, err := upgrader.Upgrade(w, r, nil)
	if err != nil {
		log.Println("upgrade error:", err)
		return
	}
	defer conn.Close()

	mutex.Lock()
	clients[conn] = true
	mutex.Unlock()

	for {
		_, msg, err := conn.ReadMessage()
		if err != nil {
			log.Println("read error:", err)
			break
		}

		// broadcast JSON to all other clients
		mutex.Lock()
		for c := range clients {
			if c != conn {
				err := c.WriteMessage(websocket.TextMessage, msg)

				if err != nil {
					log.Println("write error:", err)
					c.Close()
					delete(clients, c)
				}
			}
		}
		mutex.Unlock()
	}

	mutex.Lock()
	delete(clients, conn)
	mutex.Unlock()
}

func main() {
	log.Println("Server Start...")
	http.HandleFunc("/ws", handleWS)

	log.Println("Server started on :8090/ws")
	log.Fatal(http.ListenAndServe(":8090", nil))
}
