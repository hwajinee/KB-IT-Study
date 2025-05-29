// 구조분해 할당
// 3. 함수의 매개변수

// (1) 매개변수를 받으면서 바로 구조분해 할당
function addContact1({ name, phone, email = '없음', age = 20 }) {
  console.log(name, phone, email, age);
}
addContact1({
  name: '최화진',
  phone: '010-1234-1234',
  age: 27,
});

// (2)
function addContact2(contact) {
  // 속성이 없으면 초기화. default parameter와 같은 기능
  if (!contact.email) contact.email = '없음';
  if (!contact.age) contact.age = 25;
  let { name, phone, email, age } = contact;
  console.log(name, phone, email, age);
}
addContact2({ name: '박지원', phone: '010-5678-5678', email: 'qwer' });

// (3) 구조분해 할당 없이 기본 매개변수 사용
function addContact3(name, phone, email = '없음', age = 0) {
  console.log(name, phone, email, age);
}
addContact3('서동우', '010-2468-2468', 'asdf');
