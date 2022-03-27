// Bài 1: Viết function truyền vào 1 số nguyên dường. Tính giai thừa của số đó
// Ví dụ: calculateFactorial(5) = 5 * 4 * 3 * 2 * 1 = 120
function calculateFactorial(a) {
    if (a == 0) {
        return 1;
    }
    return a * calculateFactorial(a - 1)
}
console.log(calculateFactorial(5));

// Bài 2: Viết function truyền vào 1 chuỗi. In ra chuỗi đảo ngược của chuỗi đó

// Ví dụ: reverseString(‘hello’) => olleh
function reverseString(str) {
    return str.split('').reverse().join('');
}
console.log(reverseString("hello"));

//   Bài 3: Viết function truyền vào mã quốc gia. Trả về message có ý nghĩa là “Xin chào”, tương ứng với mã quốc gia được truyền vào

// Ví dụ: translate(‘VN’) => “Xin chào”
// translate(‘EN’) => “Hello”
function codeNational(code) {
    switch (code) {
        case "VN": {
            alert("Xin chào")
            break;
        }
        case "EN": {
            alert("Hello")
            break;
        }
        case "CHINA": {
            alert("Ní Hảo")
            break;
        }
    }
}
console.log(codeNational("VN"));

// Bài 4: Cho function truyền vào 1 chuỗi dài hơn 15 ký tự. Viết 1 function cắt chuỗi, lấy ra 10 ký tự đầu tiên và thêm vào dấu “…” ở cuối chuỗi.

// Ví dụ : subString(“xinchaocacbandenvoiTechmaster”) => “xinchaocac…”
function trimString(str) {
    console.log(str.slice(0, 10));
}
console.log(trimString("123456789101112131415"));

