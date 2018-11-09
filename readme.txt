CL 是一个直接继承自 ViewGroup 并实现 NestedScrollingParent 接口的控件，
它主要的功能，就是协调其内部的各个子控件之间的状态关系。

简单来说，如果需要在布局中协调多个 View 进行互动，例如：**移动**、动画等等。
在以前，是需要同时对这些 View 进行操作并响应各自的状态的，而有了 CL ，
这些它都帮我们实现好了交互的接口，我们只需要去关心具体的细节。

在 DSL 中，很多地方都用到了 CL，举几个例子：
- SnackBar 出现的时候，浮动操作按钮（FAB）上移。
- 配合 ToolBar ，实现一个可伸缩头部 Title。
- 配合 AppBarLayout，实现一个具体的是视差动画的效果。

虽然这里讲的是 CL ，但是其实对于开发者而言，我们是不会和 CL 直接打交道的，
而 CL 透出来的接口 Behavior 才是我们需要关心和实现的。

CL 和 Behavior 之间进行交互，Behavior将需要被协调的 View 之间的变动，
传递给CL，开发者只需要针对 Behavior 中定义好的接口方法，进行对应的实现即可。

CL 和 Behavior 的通信模式有一点像设计模式里的观察者模式。
对于 CL 内部的子 View 而言，都可以是被观察者，而 CL 观察这些被观察的 View 的行为，
例如：移动、滚动等等，当观察到这些被观察的View的行为的时候，
再通过 Behavior 通知给需要观察它状态的 View，被观察的View的变动情况。

而在 Behavior 中，存在的角色就是 dependency 和 child 。
如果 child 依赖 dependency 的行为来触发某些对应动作，那么他们之间就建立了依赖的关系。

如何实现联动效果<br>
1. 熟悉一下API
public static abstract class Behavior<V extends View>
我们主要用到它的两方法：
boolean layoutDependsOn(parent,child,dependency)：判断 child 是否依赖 dependency。
boolean onDependentViewChange(parent,child,dependency)：如果layoutDependsOn 中返回true，在此方法中 child 实现根据依赖的 dependency 的变动情况变动 child。
2. 开始编写Behavior
3. 在布局中为控件指定MyBehavior

总之，在Bim5d使用CoordinateLayout的纪律很低

参考网址：https://www.jianshu.com/p/ed569a44225a
        https://blog.csdn.net/huachao1001/article/details/51554608

