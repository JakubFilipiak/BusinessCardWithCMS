package jakubfilipiak.BusinessCardWithCMS.models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Jakub Filipiak on 05.10.2019
 */
public class OfferEntityTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void shouldCorrectCreateOfferEntityWhenGivenUUID() {
        // given
        UUID givenUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        OfferEntity offerEntity;

        // when
        offerEntity = new OfferEntity.OfferEntityBuilder()
                .id(givenUUID)
                .build();

        // then
        assertThat(offerEntity.getId()).isEqualByComparingTo(givenUUID);
    }

    @Test
    public void shouldCorrectCreateOfferEntityWhenNotGivenUUID() {
        // given
        OfferEntity offerEntity;

        // when
        offerEntity = new OfferEntity.OfferEntityBuilder().build();

        // then
        assertThat(offerEntity.getId()).isNotNull();
    }

    @Test
    public void shouldCorrectCreateOfferEntityWhenGivenTitle() {
        // given
        OfferEntity offerEntity;
        String givenDescription = "description1";

        // when
        offerEntity = new OfferEntity.OfferEntityBuilder()
                .description(givenDescription)
                .build();

        // then
        assertThat(offerEntity.getDescription()).isEqualTo(givenDescription);
    }

    @Test
    public void shouldCorrectCreateOfferEntityWhenGivenDescription() {
        // given
        OfferEntity offerEntity;
        String givenTitle = "title1";

        // when
        offerEntity = new OfferEntity.OfferEntityBuilder()
                .title(givenTitle)
                .build();

        // then
        assertThat(offerEntity.getTitle()).isEqualTo(givenTitle);
    }
}