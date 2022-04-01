// //Câu 1. Tạo 1 thẻ p có id=“text”, có nội dung bất kỳ (có thể tạo bằng HTML hay Javascript - tùy chọn). Yêu cầu

// Đặt màu văn bản thành #777
// Đặt kích thước phông chữ thành 2rem
// Đặt nội dung HTML thành Tôi có thể làm <em> bất cứ điều gì </em> tôi muốn với JavaScript.
const text = document.getElementById("text");
text.style.color = "red";
text.style.fontSize = "2rem";
text.innerHTML = "Tôi có thể làm <em> bất cứ điều gì </em> tôi muốn với JavaScript"

// Câu 2. Sử dụng vòng lặp để đặt màu chữ cho tất cả thẻ li thành màu blue (tạo thẻ ul-li bằng html)

// <ul>
//     <li>Item 1</li>
//     <li>Item 2</li>
//     <li>Item 3</li>
// </ul>
const liAll = document.querySelectorAll("li");
console.log(liAll);
for (let i = 0; i < liAll.length; i++) {
    liAll[i].style.color= "blue";
}

// Câu 3:Cho mã HTML có nội dung như sau (tạo thẻ ul-li bằng html):

// <ul id="list">
//    <li>Item 1</li>
//    <li>Item 2</li>
//    <li>Item 3</li>
//    <li>Item 4</li>
//    <li>Item 5</li>
//    <li>Item 6</li>
//    <li>Item 7</li>
// </ul>

// Sử dụng javascript để thực hiện những công việc sau

//1: Thêm 3 thẻ <li> có nội dung Item 8, Item 9, Item 10 vào cuối danh sách
const list = document.getElementById("list")
list.insertAdjacentHTML("afterend", 
"<li>Item 8</li> <li>Item 9</li> <li>Item 10</li>")

//2: Sửa nội dung cho thẻ <li> 1 thành màu đỏ (color)
const li1 = document.querySelectorAll("li:nth-child(1)")
console.log(li1);
for (let i = 0; i < li1.length; i++) {
    li1[i].style.color = "red"
    
}
//3: Sửa background cho thẻ <li> 3 thành màu xanh (background-color)
const li3 = document.querySelectorAll("li:nth-child(3)")
console.log(li3);
for (let i = 0; i < li3.length; i++) {
    li3[i].style.color = "white"
    li3[i].style.backgroundColor = "blue"
    
}
//4: Remove thẻ <li> 4
const li4 = document.querySelector("li:nth-child(4)")
console.log(li4);

li4.parentNode.removeChild(li4);

//5: Thêm thẻ <li> mới thay thế cho thẻ <li> 4 bị xóa ở bước trước, thẻ <li> mới có nội dung bất kỳ
const li3_list = document.querySelector("#list li:nth-child(3)");
console.log(li3_list);
li3_list.insertAdjacentHTML("afterend","<li>Đây là thẻ thay thế</li>")
