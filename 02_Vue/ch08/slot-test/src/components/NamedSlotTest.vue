<template>
  <div>
    <h3>당신이 경험한 프론트엔드 기술은?(세번째: named Slot)</h3>
    <CheckBox3
      v-for="item in items"
      :key="item.id"
      :id="item.id"
      :label="item.label"
      :checked="item.checked"
      @check-changed="CheckBoxChanged"
    >
      <!-- slot의 개수가 2개 이상일 때는 template태그로 묶고,
      v-slot:slot명 또는 #슬롯명 으로 슬롯이름을 붙여준다. -->
      <template v-slot:icon>
        <i v-if="item.checked" class="far fa-grin-beam"></i>
        <i v-else class="far fa-frown"></i>
      </template>

      <template #label>
        <span
          v-if="item.checked"
          style="color: blue; text-decoration: underline"
        >
          <i>{{ item.label }}</i></span
        >
        <span v-else style="color: gray">{{ item.label }}</span>
      </template>
    </CheckBox3>
  </div>
</template>

<script>
import CheckBox3 from './CheckBox3.vue';

export default {
  name: 'NamedSlotTest',
  components: { CheckBox3 },
  data() {
    return {
      items: [
        { id: 'V', checked: true, label: 'Vue' },
        { id: 'A', checked: false, label: 'Angular' },
        { id: 'R', checked: false, label: 'React' },
        { id: 'S', checked: false, label: 'Svelte' },
      ],
    };
  },
  methods: {
    // 받아온 객체의 id를 items 배열에서 찾고 일치하는 객체 반환
    CheckBoxChanged(e) {
      let item = this.items.find((item) => item.id === e.id);
      // 찾은 객체의 checked를 받아온 값으로 변경
      item.checked = e.checked;
    },
  },
};
</script>
<style>
@import url('https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css');
</style>
