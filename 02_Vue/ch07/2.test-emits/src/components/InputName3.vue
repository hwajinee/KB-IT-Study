<!-- 이벤트 유효성 검사 2. 이벤트명과 세부 조건까지 고려 -->

<template>
  <div style="border: solid 1x gray; padding: 5px">
    이름: <input type="text" v-model="name" />
    <button @click="$emit('nameChanged', { name })">이벤트 발신3</button>
  </div>
</template>

<script>
export default {
  name: 'InputName3',
  emits: {
    // 해당 이벤트 객체의 name을 체크하는 유효성 검사
    // 조건이 맞지 않으면 경고창 출력
    nameChanged: (e) => {
      return e.name && typeof e.name === 'string' && e.name.trim().length >= 3
        ? true
        : false;
    },
  },
  data() {
    return { name: '' };
  },
};
</script>
