Book Manager App

<div align="center"><img src="https://img.shields.io/badge/Kotlin-Android-purple?style=for-the-badge&logo=kotlin" />
<img src="https://img.shields.io/badge/Android-Jetpack-3DDC84?style=for-the-badge&logo=android" />
<img src="https://img.shields.io/badge/Architecture-MVVM-blue?style=for-the-badge" /></div><div dir="rtl" align="right"><h2>نبذة عن التطبيق</h2>تطبيق Android بسيط لإدارة الكتب باستخدام Kotlin.

يتيح التطبيق للمستخدم إضافة الكتب وتعديلها وحذفها، مع عرض قائمة الكتب باستخدام RecyclerView وإدارة البيانات من خلال ViewModel وLiveData.

<h2>الميزات</h2>- إضافة كتب جديدة
- تعديل الكتب الموجودة
- حذف الكتب بالضغط المطول
- عرض قائمة الكتب باستخدام RecyclerView
- استخدام Fragments لعرض وإدارة الواجهات
- استخدام DialogFragment لإضافة وتعديل الكتب
- إدارة البيانات باستخدام ViewModel
- تحديث واجهة المستخدم عند تغير البيانات باستخدام LiveData

</div><div dir="ltr" align="left"><h2>Tech Stack</h2>Technology| Usage
Kotlin| Primary programming language
RecyclerView| Books list
Adapter| Binding book data to the list
Fragments| UI screens
ViewModel| Data management
LiveData| Observing data changes
DialogFragment| Adding and editing books
XML| UI layouts

</div><div dir="rtl" align="right"><h2>طريقة الاستخدام</h2>1. افتح التطبيق لعرض قائمة الكتب.
2. لإضافة كتاب جديد، افتح واجهة إضافة الكتاب وأدخل بياناته.
3. لحفظ الكتاب، قم بتأكيد عملية الإضافة.
4. لتعديل كتاب، اضغط عليه لفتح واجهة التعديل.
5. لحذف كتاب، اضغط عليه ضغطة مطولة.
6. يتم تحديث القائمة عند إضافة أو تعديل أو حذف البيانات.

</div><div dir="ltr" align="left"><h2>Architecture</h2>The application uses the MVVM architecture pattern.

ViewModel is responsible for managing the application data, while LiveData is used to observe changes and update the UI.

RecyclerView and Adapter are used to display the list of books, while DialogFragment is used for adding and editing book data.

<h2>Getting Started</h2><h3>Requirements</h3>- Android Studio
- Android SDK
- Kotlin

<h3>Setup</h3>1. Clone the repository.
2. Open the project in Android Studio.
3. Sync the project with Gradle.
4. Build and run the application.

<h2>Project Status</h2>Completed educational Android project.

</div><div dir="ltr" align="left"><h2>Author</h2>Ahmed Ali Aldhmshi

GitHub: "ahmedaldhmshidev-art" (https://github.com/ahmedaldhmshidev-art)

</div>