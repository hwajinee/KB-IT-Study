// 가변 매개변수는 맨 뒤에 1개만 지정 가능
function foodReport(name, age, ...favoriteFoods) {
  console.log(`${name}, ${age}`);
  // 내부에서 쓸 때는 ... 붙이지 않음.
  console.log(favoriteFoods);
}

foodReport('최화진', 27, '초밥', '돈까스', '된장찌개');
foodReport('박지원', 37, '삼겹살');
