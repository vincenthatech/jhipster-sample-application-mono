package io.newl.inventory.domain;

import static io.newl.inventory.domain.CountryTestSamples.*;
import static io.newl.inventory.domain.RegionTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import io.newl.inventory.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class RegionTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Region.class);
        Region region1 = getRegionSample1();
        Region region2 = new Region();
        assertThat(region1).isNotEqualTo(region2);

        region2.setId(region1.getId());
        assertThat(region1).isEqualTo(region2);

        region2 = getRegionSample2();
        assertThat(region1).isNotEqualTo(region2);
    }

    @Test
    void countryTest() {
        Region region = getRegionRandomSampleGenerator();
        Country countryBack = getCountryRandomSampleGenerator();

        region.setCountry(countryBack);
        assertThat(region.getCountry()).isEqualTo(countryBack);
        assertThat(countryBack.getRegion()).isEqualTo(region);

        region.country(null);
        assertThat(region.getCountry()).isNull();
        assertThat(countryBack.getRegion()).isNull();
    }
}
