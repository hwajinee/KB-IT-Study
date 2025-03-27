<template>
  <div class="app">
    <div class="title fs-2 fw-bold text-info">Simple Budget Diary</div>
    <br />
    <div class="row">
      <div class="col-md-12">
        <div class="col">
          <ExpenseForm @add-expense="addList" />
        </div>
      </div>
    </div>
    <br />
    <div class="container">
      <div class="fs-5 fw-bold text-info">지출 내역</div>
      <br />
      <div class="row">
        <div class="col">
          <ul class="list-group" v-for="i in list">
            <li
              class="list-group-item text-white bg-dark mb-1 rounded-2"
              style="border: 0px"
            >
              {{ i.item }} : {{ i.amount }}원
            </li>
          </ul>
        </div>
      </div>
    </div>
    <br />
    <div class="container">
      <div class="fs-5 fw-bold text-info">총 지출: {{ totalAmount }}원</div>
    </div>
  </div>
</template>

<script>
import { ref } from 'vue';
import ExpenseForm from './components/ExpenseForm.vue';

export default {
  name: 'App',
  components: { ExpenseForm },
  setup() {
    const totalAmount = ref(0);
    const list = ref([]);
    const addList = (expense) => {
      list.value.push({ item: expense.item, amount: expense.amount });
      totalAmount.value += expense.amount;
    };
    return { list, addList, totalAmount };
  },
};
</script>

<style>
.app {
  background-color: #1e1e1e;
  color: #f0f0f0;
  padding: 30px;
  font-family: 'Segoe UI', sans-serif;
  max-width: 600px;
  margin: 50px auto;
  border-radius: 16px;
  box-shadow: 0 0 30px rgba(0, 0, 0, 0.3);
}
</style>
