package ch.noseryoung.uek295yacordiscount.domain.discount;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/discounts")
public class DiscountController {

    @Autowired
    public DiscountService service;

    @GetMapping()
    @PreAuthorize("hasAuthority('READ')")
    @Operation(description = "Receive a list of all discounts stored in the DB. Requires READ Authority", summary = "All Discounts in DB")
    public ResponseEntity<List<Discount>> getAllDiscounts(){
        return ResponseEntity.ok().body(service.getAllDiscounts());
    }

    @GetMapping("/{discountId}")
    @PreAuthorize("hasAuthority('READ')")
    @Operation(description = "Receive a specific discount based on ID which is stored in the DB. Requires READ Authority", summary = "ID specific Discount in DB")
    public ResponseEntity<Discount> getDiscountById
            (@PathVariable ("discountId") Integer discountId){
        return ResponseEntity.ok().body(service.getDiscountById(discountId));
    }

    @PostMapping()
    @PreAuthorize("hasAuthority('CREATE')")
    @Operation(description = "Add a discount which will be stored in the DB. Code will automatically be generated. Requires CREATE Authority", summary = "Add Discount in DB")
    public ResponseEntity<Discount> addDiscount
            (@Valid @RequestBody Discount discount){
        Discount createdDiscount = service.addDiscount(discount);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDiscount);
    }

    @PutMapping("/{discountId}")
    @PreAuthorize("hasAuthority('UPDATE')")
    @Operation(description = "Update values in a existing discount which is stored in the DB. Requires UPDATE Authority", summary = "Update Discount values in DB")
    public ResponseEntity<Object> updateDiscount
            (@PathVariable ("discountId") Integer discountId, @Valid @RequestBody Discount discount ){
        return ResponseEntity.ok().body(service.updateDiscount(discountId, discount));
    }

    @DeleteMapping("/{discountId}")
    @PreAuthorize("hasAuthority('DELETE')")
    @Operation(description = "Delete a discount which is stored in the DB. Requires DELETE Authority", summary = "Delete Discount in DB")
    public String deleteDiscount(@PathVariable ("discountId") Integer discountId){
        service.deleteDiscount(discountId);
        return "Discount has been deleted.";
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException element) {
        return ResponseEntity.badRequest().body(element.getBindingResult().getFieldError().getField() + " is invalid: "
                + element.getBindingResult().getFieldError().getDefaultMessage());
    }


    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException noSuchElementException){
        return ResponseEntity.status(404).body(noSuchElementException.getMessage());
    }



}
