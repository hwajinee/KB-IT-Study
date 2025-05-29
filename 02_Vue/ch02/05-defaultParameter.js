// 기본 매개변수는 무조건 뒤쪽에
function addContact(
  name,
  mobile,
  home = '없음',
  address = '없음',
  email = '없음'
) {
  let str =
    `name=${name}, mobile=${mobile}, home=${home},` +
    ` address=${address}, email=${email}`;
  console.log(str);
}

// 값을 설정하지 않은 변수는 기본값으로 출력
addContact('홍길동', '010-1234-5678');
addContact('이몽룡', '010-1111-2222', '02-1234-1234', '서울시');
