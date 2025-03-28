<template>
  <div class="app">
    <div class="title fs-2 fw-bold app-color">Simple Budget Diary</div>
    <br />
    <div class="row">
      <div class="col-md-12">
        <ExpenseForm @add-expense="addList" />
      </div>
    </div>
    <br />
    <div class="fs-5 fw-bold app-color">지출 내역</div>
    <br />
    <ExpenseList :expenses="expenses" />
    <!-- <div class="row">
      <div class="col">
        <ul class="list-group">
          <li
            v-for="(exp, idx) in expenses"
            :key="idx"
            class="list-group-item text-white bg-dark mb-1 rounded-2"
            style="border: 0px"
          >
            {{ exp.item }} : {{ exp.amount }}원
          </li>
        </ul>
      </div>
    </div> -->

    <br />
    <TotalDisplay :totalAmount="totalAmount" :formatNumber="formatCurrency" />
    <!-- <div class="container">
      <div class="fs-5 fw-bold app-color">총 지출: {{ totalAmount }}원</div>
    </div> -->
  </div>
</template>

<script setup>
import { ref } from 'vue';
import ExpenseForm from './components/ExpenseForm.vue';
import TotalDisplay from './components/TotalDisplay.vue';
import ExpenseList from './components/ExpenseList.vue';

const totalAmount = ref(0);
const expenses = ref([]);

const addList = (expense) => {
  expenses.value.push(expense);
  totalAmount.value += expense.amount;
};

const formatCurrency = (n) => {
  return '₩' + n.toLocaleString();
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
.app-color {
  color: skyblue;
}
</style>
