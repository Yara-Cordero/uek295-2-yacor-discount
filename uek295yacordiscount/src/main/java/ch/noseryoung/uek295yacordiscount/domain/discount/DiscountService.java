package ch.noseryoung.uek295yacordiscount.domain.discount;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DiscountService {

    @Autowired
    private DiscountRepository repository;


    public List<Discount> getAllDiscounts(){
        return repository.findAll();
    }

    public Discount getDiscountById(int index){
        return repository.findById(index).orElseThrow(() -> new NoSuchElementException("GET: Discount with ID " + index + " could not be found."));
    }

    public Discount addDiscount(Discount discount){
        return repository.save(discount);
    }

    public Discount updateDiscount(int index, Discount discount){
        Discount existingDiscount = repository.findById(index).orElseThrow(() -> new NoSuchElementException("UPDATE: Discount with ID " + index + " could not be found"));
        if (existingDiscount != null){
            existingDiscount.setCode(discount.getCode());
            existingDiscount.setDiscountInPercent(discount.getDiscountInPercent());
            existingDiscount.setClientId(discount.getClientId());

            return repository.save(existingDiscount);
        }
        return null;
    }

    public void deleteDiscount(int index){
        Discount discount;
        discount = repository.findById(index).orElseThrow(() -> new NoSuchElementException("DELETE: Discount with ID " + index + " could not be found"));
        repository.delete(discount);
    }
}
