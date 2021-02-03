package ru.edu.asu.wms.wmsdoors.Invoice

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.edu.asu.wms.wmsdoors.Сontractor.Contractor
import ru.edu.asu.wms.wmsdoors.Сontractor.СontractorRepository

@Service
class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository

    List<Contractor> getAllInvoices() {
        return invoiceRepository.findAll()
    }

    Invoice updateInvoice(Invoice entity, Integer id) {
        Invoice val = invoiceRepository.getOne(id)
        val.setContractor(entity.getContractor())
        val.setName(entity.setName())
        val.setDate(entity.getDate())
        return invoiceRepository.save(val)
    }

    Invoice createInvoice(Invoice val) {
        return invoiceRepository.save(val)
    }

    String deleteInvoice(Integer id) {
        invoiceRepository.deleteById(id)
        return "Сведения о накладной удалены"
    }

    Invoice getInvoice(Integer id) {
        return invoiceRepository.getOne(id)
    }



}
