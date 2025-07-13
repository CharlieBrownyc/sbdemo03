package kr.co.brownyc.es8.entity;

import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Mapping;
import org.springframework.data.elasticsearch.annotations.Setting;
import org.springframework.data.elasticsearch.annotations.WriteTypeHint;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Document(indexName = "posts", writeTypeHint = WriteTypeHint.FALSE)
@Setting(settingPath = "elastic/post-setting.json")
@Mapping(mappingPath = "elastic/post-mapping.json")
public class PostDocument {

    @Id
    private Long id;
    private String username;
    private String title;
    private String content;

    @Builder
    public PostDocument(Long id, String username, String title, String content) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.content = content;
    }

    public static PostDocument from(Post post) {
        return PostDocument.builder()
                .id(post.getId())
                .username(post.getUsername())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }

}
