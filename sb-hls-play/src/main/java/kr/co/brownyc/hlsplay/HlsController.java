package kr.co.brownyc.hlsplay;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HlsController {

    @GetMapping("/live")
    public String live(Model model) {
        model.addAttribute("title", "LIVE STREAM");
        model.addAttribute("hlsUrl", "http://localhost:18080/hls/stream.m3u8");
        return "player";
    }
}
