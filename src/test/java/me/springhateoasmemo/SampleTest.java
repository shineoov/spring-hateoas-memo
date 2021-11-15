package me.springhateoasmemo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.hateoas.*;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.hateoas.TemplateVariable.*;


public class SampleTest {

    @Test
    public void basicLinks() throws Exception {

        Link link = Link.of("/something");

        assertThat(link.getHref()).isEqualTo("/something");
        assertThat(link.getRel()).isEqualTo(IanaLinkRelations.SELF);

        link = Link.of("/something", "my-rel");

        assertThat(link.getHref()).isEqualTo("/something");
        assertThat(link.getRel()).isEqualTo(LinkRelation.of("my-rel"));
    }


    @Test
    public void basicTemplateURI() throws Exception {
        Link link = Link.of("/{segment}/something{?parameter}");

        assertThat(link.isTemplated()).isTrue();
        assertThat(link.getVariableNames()).contains("segment", "parameter");

        HashMap<String, Object> values = new HashMap<>();
        values.put("segment", "path");
        values.put("parameter", 42);

        assertThat(link.expand(values).getHref()).isEqualTo("/path/something?parameter=42");
    }

    @Test
    public void workTemplatesURI() throws Exception {
        UriTemplate template = UriTemplate.of("/segment/something")
                .with(new TemplateVariable("parameter", VariableType.REQUEST_PARAM));

        assertThat(template.toString()).isEqualTo("/segment/something{?parameter}");
    }

    @Test
    @DisplayName("Internet Assigned Numbers Authority")
    public void IANA_Link() throws Exception {
        Link link = Link.of("/some-resource", IanaLinkRelations.NEXT);

        assertThat(link.getRel()).isEqualTo(LinkRelation.of("next"));
        assertThat(IanaLinkRelations.isIanaRel(link.getRel())).isTrue();
    }

}
