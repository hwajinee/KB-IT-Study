<!-- 이벤트 유효성 검사 1. 이벤트명 확인 -->

<template>
  <div style="border: solid 1x gray; padding: 5px">
    이름: <input type="text" v-model="name" />
    <button @click="$emit('nameChanged', { name })">이벤트 발신2</button>
  </div>
</template>

<script>
export default {
  name: 'InputName',
  // 이벤트명 명시, 이외에 다른 이벤트를 받을 경우 경고 출력
  emits: ['nameChanged1'],
  data() {
    return { name: '' };
  },
};
</script>
