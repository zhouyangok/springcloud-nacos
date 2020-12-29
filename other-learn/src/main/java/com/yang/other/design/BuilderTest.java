package com.yang.other.design;

/**
 * @ClassName BuilderTest
 * @Description: 建造者模式
 * @Author zhouyang
 * @Date 2020/12/29 上午10:48.
 */

public class BuilderTest {
    public static void main(String[] args) {
//        ProductModel productModel = new ProductModel();
//        productModel.setProductName("xxx");

        ProductBuilder productBuilder = new DefaultConcreteProductBuilder();
        Director director = new Director(productBuilder);
        ProductModel productModel = director.makeProduct("name", "companyName", "part1");
        System.out.println(productModel);
    }
}

interface ProductBuilder {
    void builderProductName(String productName);

    void builderCompanyName(String companyName);

    void builderPart1(String part1);

    void builderPart2(String part2);

    ProductModel build();
}

class DefaultConcreteProductBuilder implements ProductBuilder {
    private String productName;
    private String companyName;
    private String part1;
    private String part2;
    private String part3;
    private String part4;

    @Override
    public void builderProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public void builderCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public void builderPart1(String part1) {
        this.part1 = part1;
    }

    @Override
    public void builderPart2(String part2) {
        this.part2 = part2;
    }

    @Override
    public ProductModel build() {
        return new ProductModel();
    }

}

class Director {
    public Director(ProductBuilder builder) {
        this.builder = builder;
    }

    private ProductBuilder builder;

    public ProductModel makeProduct(String productName, String companyName, String part1) {
        builder.builderProductName(productName);
        builder.builderCompanyName(companyName);
        builder.builderPart1(part1);
        ProductModel product = builder.build();
        return product;
    }
}


class ProductModel {

    private String productName;
    private String companyName;
    private String part1;
    private String part2;
    private String part3;
    private String part4;
    //...

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }

    public void setPart3(String part3) {
        this.part3 = part3;
    }

    public void setPart4(String part4) {
        this.part4 = part4;
    }
}
