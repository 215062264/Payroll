package za.ac.deklerkbasson.service.demography.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import za.ac.deklerkbasson.domain.demography.Race;
import za.ac.deklerkbasson.repositoryTest.demography.Impl.RaceRepositoryImpl;
import za.ac.deklerkbasson.repositoryTest.demography.RaceRepository;
import za.ac.deklerkbasson.service.demography.RaceService;

import java.util.Set;

@Service("ServiceImpl")
public class RaceServiceImpl implements RaceService {
    @Autowired
    @Qualifier("InMemory")
    private static RaceServiceImpl service = null;
    private RaceRepository repository;

    private RaceServiceImpl() {
        this.repository = RaceRepositoryImpl.getRaceRepositoryImpl();
    }

    public static RaceServiceImpl getService() {
        if (service == null) service = new RaceServiceImpl();
        return service;
    }

    @Override
    public Race create(Race race) {
        return this.repository.create(race);
    }

    @Override
    public Race update(Race race) {
        return this.repository.update(race);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Race read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Race> getAll() {
        return this.repository.getAll();
    }
}

