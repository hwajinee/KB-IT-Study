<template>
  <div class="fs-5 fw-bold app-color">
    총 지출: {{ formatNumber(totalAmount) }}원
  </div>
</template>
<script setup>
const props = defineProps({
  totalAmount: { type: Number, required: true },
  formatNumber: { type: Function, required: true },
});
</script>
