<script setup lang="ts">
import {ref} from "vue";
import axios from "axios";

const quotation = ref([]);

axios.get("/api/warehouse/quotation").then(response => {
  response.data.data.forEach((r: any) => {
    quotation.value.push(r)
  });
});
</script>


<template>
<div>
<el-table :data="quotation">
  <el-table-column prop="itemId.itemCode" label="상품코드" />
  <el-table-column prop="itemId.typeCode" label="분류코드" />
  <el-table-column prop="itemId.typeName" label="분류이름" />
  <el-table-column prop="itemId.name" label="상품이름" />
  <el-table-column prop="quantity" label="수량" />
  <el-table-column prop="totalPrice" label="총 금액" />
</el-table>
  <el-form-item>
    <el-button type="primary" @click="itemCreate(rowId)">
      상품 추가
    </el-button>
    <el-button type="danger" @click="itemCreate(rowId)">
      상품 삭제
    </el-button>
  </el-form-item>
</div>


</template>