import Vue from "vue";
import Router from "vue-router";

// Containers
const TheContainer = () => import("@/containers/TheContainer");

// Views
const Dashboard = () => import("@/views/Dashboard");

//Crud
const incluir = () => import("@/views/crud/incluir");
const remover = () => import("@/views/crud/remover");
const editar = () => import("@/views/crud/editar");
const listar = () => import("@/views/crud/listar");

Vue.use(Router);

export default new Router({
  mode: "hash", // https://router.vuejs.org/api/#mode
  linkActiveClass: "active",
  scrollBehavior: () => ({ y: 0 }),
  routes: configRoutes(),
});

function configRoutes() {
  return [
    {
      path: "/",
      redirect: "/dashboard",
      name: "Home",
      component: TheContainer,
      children: [
        {
          path: "dashboard",
          name: "Equipe",
          component: Dashboard,
        },
        {
          path: "/crud",
          redirect: "/crud/incluir",
          name: "crud",
          component: {
            render(c) {
              return c("router-view");
            },
          },
          children: [
            {
              path: "incluir",
              name: "incluir",
              component: incluir,
            },
            {
              path: "remover",
              name: "remover",
              component: remover,
            },

            {
              path: "editar",
              name: "editar",
              component: editar,
            },
            {
              path: "listar",
              name: "listar",
              component: listar,
            },
          ],
        },
      ],
    },
  ];
}
