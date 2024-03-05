package product;



import common.UtilService;
import common.UtilServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class ProductView {
    public static void main(String[] args) {
        List<Product> pList = new ArrayList<>();
        UtilService util = UtilServiceImpl.getInstance();

        for (int i=1;i<6;i++){
            pList.add(Product.builder()
                    .pno(i)
                    .name("상품"+i)
                    .company(util.creatRandomCompany())
                    .price(util.createRandomInteger(1000,9999))
                    .build());
        }

        pList.forEach(i ->{
            System.out.println(i.toString());
        });


    }
}
