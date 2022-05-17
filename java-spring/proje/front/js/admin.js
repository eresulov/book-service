// Getting HTML Elements
var computerCategoriesElement = document.getElementById('computer-categories-div');
var categoryNameInputElement = document.getElementById('category-name-input');
var saveCategoryButtonElement = document.getElementById('save-category-button');
var resetCategoryFormButtonElement = document.getElementById('reset-category-form-button');
var saveCategoryFormElement = document.getElementById('save-category-form');
var deleteCategoryButtonElement = document.getElementById('delete-category-button');
var mainContentElement = document.getElementById('main-content');
var categorySearchInputElement = document.getElementById('category-search-input');

// Səhifə açılanda icra olunan əməliyyatlar
deleteCategoryButtonElement.style.display = 'none';

// Qlobal dəyişənlər
var editMode = false;
var selectedComputerCategoryId = 0;
var categories = [];
var categoriesString = localStorage.getItem("categories");
var loggedInUserName = localStorage.getItem("logged-in-user-name");
var currentSelectedCategoryId = 0;
var currentSelectedCategoryName = '';
var categoriesGlobal = [];

// Kateqoriyaları yaddaşdan götürmək
if (categoriesString == null) {

} else {
    categories = JSON.parse(categoriesString);
    categoriesGlobal = categories.slice();
}

// Əgər bu səhifəyə daxil olan admin deyilsə, onda, giriş səhifəsinə yönləndirmək
if (loggedInUserName != 'admin') {
    categories = [];
    window.location.href = 'index.html';
} else {
    mainContentElement.style.display = 'block';
}

// Komputer kateqoriyalarını ekranda göstərmək
function loadComputerCategories() {
    var computerCategoriesElementHTML = "<ul class='list-group'>";
    for (var i = 0; i < categories.length; i++) {
        const c = categories[i];
        computerCategoriesElementHTML += "<li class='list-group-item " +
            "list-group-item-action' id='computer-category-" + c.id + "' onclick='onCategorySelected(" + c.id + ")'>" +
            c.name + "</li>";
    }
    computerCategoriesElementHTML += "</ul>";
    computerCategoriesElement.innerHTML = computerCategoriesElementHTML;
}
loadComputerCategories();

// Siyahıdan kateqoriya seçiləndə icra olunan metod
function onCategorySelected(categoryId) {
    if (currentSelectedCategoryId === categoryId) { } else {
        currentSelectedCategoryId = categoryId;
        selectedComputerCategoryId = currentSelectedCategoryId;
        var categoryName = '';
        deleteCategoryButtonElement.style.display = 'inline-block';
        for (let index = 0; index < categories.length; index++) {
            const c = categories[index];
            if (c.id === categoryId) {
                document.getElementById('computer-category-' + c.id).style.color = 'blue';
                document.getElementById('computer-category-' + c.id).style.fontWeight = 'bold';
                categoryName = c.name;
            } else {
                document.getElementById('computer-category-' + c.id).style.color = 'black';
                document.getElementById('computer-category-' + c.id).style.fontWeight = 'normal';
            }
        }
        categoryNameInputElement.value = categoryName;
        currentSelectedCategoryName = categoryName;
        saveCategoryButtonElement.innerHTML = 'Redaktə et';
        saveCategoryButtonElement.disabled = true;
        saveCategoryButtonElement.style.cursor = 'not-allowed';
        editMode = true;
    }
}

// Formu təmizləmək
resetCategoryFormButtonElement.addEventListener('click', function () {
    resetForm();
});

// Kateqoriya adını yadda saxlamaq
function onSaveCategory(event) {
    event.preventDefault();
    var computerCategory = {};
    var categoryId = 0;
    for (let index = 0; index < categoriesGlobal.length; index++) {
        const c = categoriesGlobal[index];
        if (c.id > categoryId) {
            categoryId = c.id;
        }
    }
    categoryId++;
    computerCategory.id = categoryId;
    computerCategory.name = categoryNameInputElement.value.trim();
    if (editMode) {
        var categoryExists = false;
        for (let index = 0; index < categoriesGlobal.length; index++) {
            const c = categoriesGlobal[index];
            if (c.name == computerCategory.name) {
                categoryExists = true; break;
            }
        }
        if (categoryExists) {
            alert('Bu kateqoriya adı artıq mövcuddur');
        } else {
            // save
            computerCategory.id = selectedComputerCategoryId;
            for (let index = 0; index < categoriesGlobal.length; index++) {
                const c = categoriesGlobal[index];
                if (c.id == selectedComputerCategoryId) {
                    categoriesGlobal[index] = computerCategory; break;
                }
            }
            localStorage.setItem('categories', JSON.stringify(categoriesGlobal)); categories = categoriesGlobal.slice();
            loadComputerCategories();
            resetForm();
            alert("Kateqoriya uğurla redaktə olundu!");
            categorySearchInputElement.value = '';
        }
    } else {
        // add
        var categoryExists = false;
        for (let index = 0; index < categoriesGlobal.length; index++) {
            const c = categoriesGlobal[index];
            if (c.name == computerCategory.name) {
                categoryExists = true; break;
            }
        }
        if (categoryExists) {
            alert('Bu kateqoriya adı artıq mövcuddur');
        } else {
            categoriesGlobal.push(computerCategory);
            localStorage.setItem('categories', JSON.stringify(categoriesGlobal)); categories = categoriesGlobal.slice();
            loadComputerCategories();
            currentSelectedCategoryId = 0;
            currentSelectedCategoryName = '';
            alert("Kateqoriya uğurla qeydiyyat olundu!");
            categorySearchInputElement.value = '';
        }
    }
}

// Siyahıdan seçilmiş kateqoriyanı silmək
deleteCategoryButtonElement.addEventListener('click', function () {
    if (editMode) {
        var result = confirm('Kateqoriyanı silməyə əminsiniz?');
        if (result) {
            for (let index = 0; index < categoriesGlobal.length; index++) {
                const c = categoriesGlobal[index];
                if (c.id == currentSelectedCategoryId) {
                    categoriesGlobal.splice(index, 1); break;
                }
            }
            categories = categoriesGlobal.slice();
            loadComputerCategories();
            localStorage.setItem('categories', JSON.stringify(categories));
            resetForm();
            alert('Silindi');
            categorySearchInputElement.value = '';
        }
    } else {
        alert('Siyahıdan seçim edilməyib');
    }
});

// Formun sıfırlanması üçün metod
function resetForm() {
    saveCategoryFormElement.reset();
    saveCategoryButtonElement.innerHTML = 'Qeydiyyat et';
    editMode = false;
    deleteCategoryButtonElement.style.display = 'none';
    currentSelectedCategoryId = 0;
    currentSelectedCategoryName = '';
}

// Kateqoriya adının yazılması zamanı icra olunan metod
function onCategoryNameChanged(categoryNameInput) {
    var localName = categoryNameInput.value.trim();
    if (localName == currentSelectedCategoryName || localName == '') {
        saveCategoryButtonElement.disabled = true;
        saveCategoryButtonElement.style.cursor = 'not-allowed';
    } else {
        saveCategoryButtonElement.disabled = false;
        saveCategoryButtonElement.style.cursor = 'pointer';
    }
}

// Kateqoriya axtarışı zamanı icra olunan metod
function searchCategory(searchInput) {
    var searchText = searchInput.value.trim();
    searchText = searchText.toLowerCase();
    categories = [];
    for (let index = 0; index < categoriesGlobal.length; index++) {
        const c = categoriesGlobal[index];
        if (c.name.toLowerCase().includes(searchText)) {
            categories.push(c);
        }
    }
    loadComputerCategories();
}