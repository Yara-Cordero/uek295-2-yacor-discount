package ch.noseryoung.uek295yacordiscount.domain.discount;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountService {

    @Autowired
    private DiscountRepository repository;


    public List<Discount> getAllDiscounts(){
        return repository.findAll();
    }

    public Discount getDiscountById(int index){
        return repository.findById(index).orElse(null);
    }

    public Discount addDiscount(Discount discount){
        discount.setDiscountId(null);
        return repository.save(discount);
    }

    public Discount updateDiscount(int index, Discount discount){
        Discount existingDiscount = repository.findById(index).orElse(null);
        if (existingDiscount != null){
            //existingDiscount.setCode(discount.getCode());
            existingDiscount.setDiscountInPercent(discount.getDiscountInPercent());
            existingDiscount.setClientId(discount.getClientId());

            return repository.save(existingDiscount);
        }
        return null;
    }

    public void deleteDiscount(int index){
        repository.deleteById(index);
    }
}
