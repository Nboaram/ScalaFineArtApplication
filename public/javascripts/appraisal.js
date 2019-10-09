(() => {
    const $fileInput = $("#file-input");
    const $imgPreviewContainer = $("#image-preview-container");
    $fileInput.change(($e) => {
        const path = $e.target.value;
        const test = "https://www.fujifilmusa.com/products/digital_cameras/x/fujifilm_x20/sample_images/img/index/ff_x20_008.JPG";
        const $newImage = $(`<img alt='image-preview' src='${path}'>`);
        $newImage.ready(($e) => {
            console.log("Loaded!");
            $imgPreviewContainer.append($newImage)
        });
    });
})();