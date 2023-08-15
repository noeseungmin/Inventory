<script lang="ts" setup>
import {RouterLink, RouterView, useRouter} from 'vue-router'
import {ref} from "vue";
import axios from "axios";
import {defineProps} from "vue/dist/vue";

const router = useRouter()

const items = ref([]);

const warehousingQuantity = ref("")

let rowId = ref("")

const itemsCreate = () => {
  router.push({
    path: "/item",
  });
};

const typesCreate = () => {
  router.push({
    path: "/type",
  });
};

const warehousing = () => {
  router.push({
    path: "/quotation",
  });
};


const rowClick = function (row) {
  rowId = row.itemId;
  console.log(rowId)
}


const itemCreate = function (rowId) {
    axios.post(`/api/warehouse/${rowId}` ,{
      warehousingQuantity: warehousingQuantity.value
    })
        .then(() => {
          router.replace({name: "quotation"});
        });
  };


axios.get("/api/items").then(response => {
  response.data.data.forEach((r: any) => {
    items.value.push(r)
  });
});


</script>

<template>
  <div class="common-layout">
    <el-container>
      <el-header>
        <el-button type="primary" @click="write()">발주요청</el-button>
        <el-button type="primary" @click="warehousing()">입고요청</el-button>
        <el-button type="primary" @click="itemsCreate()">상품등록</el-button>
        <el-button type="primary" @click="typesCreate()">상품분류추가</el-button>
      </el-header>
      <el-main>
        <el-table :data="items" @row-click="rowClick">
          <el-table-column prop="itemCode" label="상품코드"/>
          <el-table-column prop="typeCode" label="분류코드"/>
          <el-table-column prop="typeName" label="분류이름"/>
          <el-table-column prop="name" label="상품이름"/>
          <el-table-column prop="price" label="상품가격"/>
          <el-table-column prop="quantity" label="재고수량"/>
        </el-table>
        <el-row :gutter="20">
          <el-col :span="16">
            <el-form label-width="100px"
                     el-input-width="100px"
            >
              <el-form-item label="요청 수량">
                <el-input v-model="warehousingQuantity"></el-input>
              </el-form-item>
            </el-form>
          </el-col>
          <el-col :span="8">
            <el-form-item>
              <el-button type="primary" @click="itemCreate(rowId)">
                상품 추가
              </el-button>
            </el-form-item>
          </el-col>
        </el-row>
<!--        </div>-->

      </el-main>
    </el-container>
  </div>

</template>


<style>

</style>
