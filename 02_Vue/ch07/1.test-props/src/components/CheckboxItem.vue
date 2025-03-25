<template>
  <!-- :checked 는 체크박스의 체크여부 속성,
    우변에 있는 "checked" 는 부모에게서 받아온 속성 -->
  <!-- 이름을 다르게 해서 구별해도 됨ㄴ -->
  <li><input type="checkbox" :checked="checked" />{{ name }}</li>
</template>

<script>
export default {
  name: 'checkboxItem',
  // props : 부모 컴포넌트에게서 받아온 속성 배열
  props: ['name', 'checked'],
};
</script>
