package ru.edu.asu.wms.wmsdoors.Сontractor

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class СontractorService {
    @Autowired
    private СontractorRepository contractorRepository

    List<Сontractor> getAllContractors() {
        return contractorRepository.findAll()
    }

    Сontractor updateContractor(Сontractor entity, Integer id) {
        Сontractor val = contractorRepository.getOne(id)
        val.setInn(entity.getInn())
        val.setOgrn(entity.getOgrn())
        val.setName(entity.getName())
        val.setPerson(entity.getPerson())
        val.setPhone(entity.getPhone())
        val.setAddress(entity.getAddress())
        val.setEmail(entity.getEmail())
        return contractorRepository.save(val)
    }

    Сontractor createContractor(Сontractor val) {
        return contractorRepository.save(val)
    }

    String deleteContractor(Integer id) {
        contractorRepository.deleteById(id)
        return "Сведения о контрагенте удалены"
    }

    Сontractor getContractor(Integer id) {
        return contractorRepository.getOne(id)
    }
}
