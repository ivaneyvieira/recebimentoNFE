package br.com.astrosoft.entradaNF

import com.github.appreciated.app.layout.behaviour.AppLayout
import com.github.appreciated.app.layout.behaviour.Behaviour
import com.github.appreciated.app.layout.builder.AppLayoutBuilder
import com.github.appreciated.app.layout.component.appbar.AppBarBuilder
import com.github.appreciated.app.layout.component.appmenu.MenuHeaderComponent
import com.github.appreciated.app.layout.component.appmenu.left.LeftNavigationComponent
import com.github.appreciated.app.layout.component.appmenu.left.builder.LeftAppMenuBuilder
import com.github.appreciated.app.layout.design.AppLayoutDesign
import com.github.appreciated.app.layout.entity.Section.HEADER
import com.github.appreciated.app.layout.router.AppLayoutRouterLayout
import com.vaadin.flow.component.icon.VaadinIcon
import com.vaadin.flow.component.icon.VaadinIcon.COG
import com.vaadin.flow.component.page.Push
import com.vaadin.flow.component.page.Viewport

@Push
@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
class MainAppLayout : AppLayoutRouterLayout() {

  override fun getAppLayout(): AppLayout {
    val variant = Behaviour.LEFT_RESPONSIVE
    return AppLayoutBuilder
      .get(variant)
      .withTitle("Entrada de Mercadoria")
      .withAppBar(AppBarBuilder.get().build())
      .withDesign(AppLayoutDesign.CUSTOM)
      .withAppMenu(LeftAppMenuBuilder.get()
                     .addToSection(MenuHeaderComponent("Menu Principal", "Versão 1.0", null), HEADER)
                     .add(LeftNavigationComponent("Entrada", VaadinIcon.BARCODE.create(), Tela::class.java))
                     .add(LeftNavigationComponent("Consulta", VaadinIcon.SEARCH.create(), Tela::class.java))
                     .add(LeftNavigationComponent("Etiqueta de Volumes", VaadinIcon.CUBES.create(), Tela::class.java))
                     .add(LeftNavigationComponent("Etiquetas de Produtos", VaadinIcon.CUBE.create(), Tela::class.java))
                     .build()
                  ).build()
  }
}
