public class Repository {

    Product[] products = new Product[0];//пустой массив

    public void saveProducts(Product product) {//добавить продукт (новый метод)
        Product addNewProduct = findById(product.getId());
        if (addNewProduct != null) {
            throw new AlreadyExistsException(product.getId() + " такой id уже сужествует");
        }
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

//    public void saveProducts(Product product) {//добавить продукт (старый метод)
//        Product[] tmp = new Product[products.length + 1];
//        for (int i = 0; i < products.length; i++) {
//            tmp[i] = products[i];
//        }
//        tmp[tmp.length - 1] = product;
//        products = tmp;
//    }

    public void removeProductsById(int id) {//удаление продуктов по id (новый метод)
        if (findById(id) == null) {
            throw new NotFoundException("Id :" + id + " не найден");
        }
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product item : products) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        products = tmp;
    }

//    public void removeProductsById(int id) {//удаление продуктов по id (старый метод)
//        if (id < 0) {
//            throw new NegativeIdException("Id не может быть отрицательным: " + id);
//        }
//        Product[] tmp = new Product[products.length - 1];
//        int copyToIndex = 0;
//        for (Product item : products) {
//            if (item.getId() != id) {
//                tmp[copyToIndex] = item;
//                copyToIndex++;
//            }
//        }
//        products = tmp;
//    }

    public Product[] getAllProducts() {//получение продуктов
        return products;
    }

//=======================================findById=======================================//

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    /////ДОБАВИТЬ findById в метода removeById
}
