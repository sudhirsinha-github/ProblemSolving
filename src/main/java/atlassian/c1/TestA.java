package atlassian.c1;

        import java.math.BigDecimal;
        import java.util.*;
        import java.util.stream.Collectors;
        import java.util.stream.Stream;

public class TestA {

//    private final EURExchangeService exchangeService;

//    SoldProductsAggregator(EURExchangeService EURExchangeService) {
//        this.exchangeService = EURExchangeService;
//    }

    SoldProductsAggregate aggregate(Stream<SoldProduct> products) {
        List<SimpleSoldProduct> list = products
                .map( r -> convert(r))
                .collect(Collectors.toList());

//        BigDecimal total = (BigDecimal) (Double) list.stream().
//                map(r -> r.price)
//                .reduce(Double::doubleValue).sum();// this.exchangeService
        BigDecimal sum = list.stream().map(e -> e.price).reduce(BigDecimal.ZERO, BigDecimal::add);

        SoldProductsAggregate ss = new SoldProductsAggregate();
        ss.products = list;
        ss.total = sum;
        return ss;
    }

private BigDecimal add(BigDecimal a, BigDecimal b) {
    return a.add(b);
}

    private SimpleSoldProduct convert(SoldProduct soldProduct){
        SimpleSoldProduct smpleSoldProduct = new SimpleSoldProduct();
        smpleSoldProduct.name = soldProduct.name;
        smpleSoldProduct.price = soldProduct.price;


        return smpleSoldProduct;
    }
    class SoldProduct {
        String name;
        BigDecimal price;
        String currency;
    }

    class SoldProductsAggregate {
        List<SimpleSoldProduct> products;
        BigDecimal total;
    }

    class SimpleSoldProduct {
        String name;
        BigDecimal price;
    }

    interface ExchangeService {
        Optional<BigDecimal> rate(String currency);
    }

}

