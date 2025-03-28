<template>
  <div class="row">
    <div class="col">
      <ul class="list-group">
        <li
          v-for="(exp, idx) in expenses"
          :key="idx"
          class="list-group-item text-white bg-dark mb-1 rounded-2"
          style="border: 0px"
        >
          {{ getEmoji(exp.item) }} {{ exp.item }} :
          {{ exp.amount.toLocaleString() }}원
        </li>
      </ul>
    </div>
  </div>
</template>

<script setup>
const props = defineProps({
  expenses: {
    type: Array,
    required: true,
  },
});

const getEmoji = (item) => {
  if (item.includes('커피')) return '☕';
  if (item.includes('점심')) return '🍔';
  if (item.includes('택시')) return '🚕';
  return '💸';
};
</script>
