package ru.edu.asu.wms.wmsdoors.Сontractor

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class СontractorService {
    @Autowired
    private СontractorRepository contractorRepository

    List<Contractor> getAllContractors() {
        return contractorRepository.findAll()
    }

    Contractor updateContractor(Contractor entity, Integer id) {
        Contractor val = contractorRepository.getOne(id)
        val.setInn(entity.getInn())
        val.setOgrn(entity.getOgrn())
        val.setName(entity.getName())
        val.setPerson(entity.getPerson())
        val.setPhone(entity.getPhone())
        val.setAddress(entity.getAddress())
        val.setEmail(entity.getEmail())
        return contractorRepository.save(val)
    }

    Contractor createContractor(Contractor val) {
        return contractorRepository.save(val)
    }

    String deleteContractor(Integer id) {
        contractorRepository.deleteById(id)
        return "Сведения о контрагенте удалены"
    }

    Contractor getContractor(Integer id) {
        return contractorRepository.getOne(id)
    }
}
