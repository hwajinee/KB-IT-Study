<template>
  <div class="row">
    <div class="col-md-12">
      <div class="input-group">
        <input
          type="text"
          class="form-control bg-dark mx-1 rounded-2"
          v-model="item"
          style="color: aliceblue; border: 0px"
          placeholder="항목명 입력"
        />
        <input
          type="text"
          class="form-control bg-dark mx-1 rounded-2"
          v-model.number="amount"
          style="color: aliceblue; border: 0px"
          placeholder="항목명 입력"
        />
        <div class="btn btn-info mx-1 rounded-2" @click="addExpenseHandler">
          추가
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { ref } from 'vue';

export default {
  name: 'ExpenseForm',
  setup(props, context) {
    const item = ref('');
    const amount = ref(0);

    const addExpenseHandler = () => {
      context.emit('add-expense', { item: item.value, amount: amount.value });
    };

    return { item, amount, addExpenseHandler };
  },
};
</script>
<style></style>
