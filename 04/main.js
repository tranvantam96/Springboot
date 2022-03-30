let products = [
    {
        name: "Iphone 13 Pro Max", // Tên sản phẩm
        price: 30000000, // Giá mỗi sản phẩm
        brand: "Apple", // Thương hiệu
        count: 2, // Số lượng sản phẩm trong giỏ hàng
    },
    {
        name: "Samsung Galaxy Z Fold3",
        price: 41000000,
        brand: "Samsung",
        count: 1,
    },
    {
        name: "IPhone 11",
        price: 15500000,
        brand: "Apple",
        count: 1,
    },
    {
        name: "OPPO Find X3 Pro",
        price: 19500000,
        brand: "OPPO",
        count: 3,
    },
]

// 6. Thêm 1 sản phẩm bất kỳ vào trong mảng product
function addProducts(name, price, brand, count) {
    let add = {
        name: name,
        price: price,
        brand: brand,
        count: count,
    }
    products.push(add)
}
addProducts("A51", 15000000, "Samsung", 2);
console.log(products);

// // 7. Xóa tất cả sản phẩm của thương hiệu "Samsung" trong giỏ hàng

function deleteProduct(arr) { 
    let newArr = arr.filter(product => product.brand != "Samsung");
    return newArr; 
}
console.log(deleteProduct(products));

// 8. Sắp xếp giỏ hàng theo price tăng dần

products.sort((a, b) => a.price - b.price)
console.log(products);

// 9. Sắp xếp giỏ hàng theo count giảm dần

products.sort((a, b) => b.count - a.count)
console.log(products);

// 10. Lấy ra 2 sản phẩm bất kỳ trong giỏ hàng

function getRandom(arr) {
    for (let i = 0; i < 2; i++) {
        let random = Math.floor(Math.random() * 5)
            console.log(arr[random]);
        
    }
}
console.log(getRandom(products));