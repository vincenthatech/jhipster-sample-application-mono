package io.newl.inventory.service.impl;

import io.newl.inventory.domain.Region;
import io.newl.inventory.repository.RegionRepository;
import io.newl.inventory.service.RegionService;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link io.newl.inventory.domain.Region}.
 */
@Service
@Transactional
public class RegionServiceImpl implements RegionService {

    private static final Logger LOG = LoggerFactory.getLogger(RegionServiceImpl.class);

    private final RegionRepository regionRepository;

    public RegionServiceImpl(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    public Region save(Region region) {
        LOG.debug("Request to save Region : {}", region);
        return regionRepository.save(region);
    }

    @Override
    public Region update(Region region) {
        LOG.debug("Request to update Region : {}", region);
        return regionRepository.save(region);
    }

    @Override
    public Optional<Region> partialUpdate(Region region) {
        LOG.debug("Request to partially update Region : {}", region);

        return regionRepository
            .findById(region.getId())
            .map(existingRegion -> {
                if (region.getRegionName() != null) {
                    existingRegion.setRegionName(region.getRegionName());
                }

                return existingRegion;
            })
            .map(regionRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Region> findAll() {
        LOG.debug("Request to get all Regions");
        return regionRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Region> findOne(Long id) {
        LOG.debug("Request to get Region : {}", id);
        return regionRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete Region : {}", id);
        regionRepository.deleteById(id);
    }
}
