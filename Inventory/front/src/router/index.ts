import {createRouter, createWebHistory, useRouter} from 'vue-router'
import HomeView from '../views/HomeView.vue'
import WriteView from '../views/WriteView.vue'
import ItemCreateView from "../views/ItemCreateView.vue"
import TypeCreateView from "../views/TypeCreateView.vue"
import ShortageItemView from "../views/ShortageItemView.vue"
import ShortageItemSearchView from "../views/ShortageItemSearchView.vue"
import WarehousingQuotationView from "../views/WarehousingQuotationView.vue"

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: "/write",
      name: "write",
      component: WriteView
    },
    {
      path: '/item',
      name: "item",
      component: ItemCreateView
    },
    {
      path: '/type',
      name: "type",
      component: TypeCreateView
    },
    {
      path: "/shortage?typeName=:typeName&quantity=:quantity",
      name: "shortage",
      component: ShortageItemView,
      props: true
    },
    {
      path: '/shortageSearch',
      name: "shortageSearch",
      component: ShortageItemSearchView,
      props: true
    },
    {
      path: '/quotation',
      name: "quotation",
      component: WarehousingQuotationView,
      props: true
    },

    // {
    //  path: '/about',
    //  name: 'about',
    //   route level code-splitting
    //   this generates a separate chunk (About.[hash].js) for this route
    //   which is lazy-loaded when the route is visited.
    //   component: () => import('../views/AboutView.vue')
    // }
  ]
})

export default router
