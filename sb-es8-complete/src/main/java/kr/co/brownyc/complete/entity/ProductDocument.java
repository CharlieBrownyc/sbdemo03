package kr.co.brownyc.complete.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

@Data
@NoArgsConstructor
@Document(indexName = "products")
@Setting(settingPath = "elastic/es8comp-setting.json")
@Mapping(mappingPath = "elastic/es8comp-mapping.json")
public class ProductDocument {

    @Id
    private Long id;

    @Field(type = FieldType.Text, analyzer = "autocomplete", searchAnalyzer = "standard")
    private String name;

    @Field(type = FieldType.Text, analyzer = "autocomplete", searchAnalyzer = "standard")
    private String content;

    @Builder
    public ProductDocument(Long id, String name, String content) {
        this.id = id;
        this.name = name;
        this.content = content;
    }

    public static ProductDocument from(Product product) {
        return ProductDocument.builder()
                .id(product.getId())
                .name(product.getName())
                .content(product.getContent())
                .build();
    }
}
