Book Manager App
وصف المشروع:
تطبيق لإدارة الكتب يسمح بإضافة، تعديل، وحذف الكتب من خلال واجهة مستخدم منظمة.
يعتمد المشروع على Fragments لعرض البيانات، وRecyclerView + Adapter لعرض قائمة الكتب، مع استخدام ViewModel وLiveData لإدارة البيانات بشكل فعال وفصل المنطق عن الواجهة.

المميزات
إضافة كتب جديدة.
تعديل الكتب الموجودة.
حذف الكتب بسهولة عبر النقر الطويل على العنصر.
عرض قائمة الكتب باستخدام RecyclerView.
فصل إدارة البيانات عن واجهة المستخدم باستخدام ViewModel.
تحديث واجهة المستخدم تلقائيًا عند تغيير البيانات.

التقنيات المستخدمة:
لغة البرمجة: Kotlin
RecyclerView + Adapter
Fragments
ViewModel + LiveData
DialogFragment لواجهة إضافة وتعديل الكتب.

:بنية المشروع
MainActivity.kt → النشاط الرئيسي، مسؤول عن ربط RecyclerView واستقبال الأحداث.
Frag_dialog_EditAdd.kt → DialogFragment لإضافة وتعديل الكتب.
BookVM.kt → ViewModel لإدارة البيانات وتحديثها.
BookAdapter.kt → Adapter لربط البيانات بالـ RecyclerView.
Book.kt → نموذج بيانات الكتاب (id، title، content، author، releaseAt).
ActionBook.kt → Enum لتحديد نوع العملية (EDIT / DELETE).

ملاحظات:
المشروع موجه لتعلم كيفية تمرير البيانات بين Fragments وإدارة CRUD باستخدام ViewModel وLiveData.
يمكن تطوير المشروع لاحقًا بإضافة قاعدة بيانات Room لتخزين البيانات بشكل دائم.