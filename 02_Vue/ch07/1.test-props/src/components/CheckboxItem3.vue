<template>
  <li><input type="checkbox" :checked="checked" />{{ id }} - {{ name }}</li>
</template>

<script>
export default {
  name: 'checkboxItem3',
  props: {
    id: [Number, String], // id값은 Number나 String 타입
    name: String,
    checked: {
      // checked 값은 Boolean 타입이고 필수값이 아니며, 기본값은 false
      type: Boolean,
      required: false,
      default: false,
    },
  },
};
</script>
