package za.ac.deklerkbasson.service.demography.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import za.ac.deklerkbasson.domain.demography.Gender;
import za.ac.deklerkbasson.repositoryTest.demography.GenderRepository;
import za.ac.deklerkbasson.repositoryTest.demography.Impl.GenderRepositoryImpl;
import za.ac.deklerkbasson.service.demography.GenderService;

import java.util.Set;

@Service("ServiceImpl")
public class GenderServiceImpl implements GenderService {
    @Autowired
    @Qualifier("InMemory")
    private static GenderServiceImpl service = null;
    private GenderRepository repository;

    private GenderServiceImpl() {
        this.repository = GenderRepositoryImpl.getGenderRepositoryImpl();
    }

    public static GenderServiceImpl getService() {
        if (service == null) service = new GenderServiceImpl();
        return service;
    }

    @Override
    public Gender create(Gender gender) {
        return this.repository.create(gender);
    }

    @Override
    public Gender update(Gender gender) {
        return this.repository.update(gender);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Gender read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Gender> getAll() {
        return this.repository.getAll();
    }
}