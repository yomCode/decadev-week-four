package Interfaces;

import models.Products;

import java.io.IOException;
import java.util.List;

public interface ProductFileReaderInterface {

    List<Products> productList() throws IOException;
}
