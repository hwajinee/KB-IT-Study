<template>
  <li><input type="checkbox" :checked="idol.checked" />{{ idol.name }}</li>
</template>

<script>
export default {
  name: 'checkboxItem',
  // props : 부모 컴포넌트에게서 받아온 속성 배열
  props: ['idol'],
};
</script>
