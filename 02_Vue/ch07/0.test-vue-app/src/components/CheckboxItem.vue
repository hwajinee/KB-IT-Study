<template>
  <li><input type="checkbox" v-model="checked" />옵션1</li>
</template>

<script>
export default {
  name: 'checkboxItem',
  data() {
    return {
      checked: false,
    };
  },
};
</script>
