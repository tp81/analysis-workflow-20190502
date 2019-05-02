setImageType('BRIGHTFIELD_H_DAB');
setColorDeconvolutionStains('{"Name" : "H-DAB default", "Stain 1" : "Hematoxylin", "Values 1" : "0.65111 0.70119 0.29049 ", "Stain 2" : "DAB", "Values 2" : "0.26917 0.56824 0.77759 ", "Background" : " 255 255 255 "}');
if (!isTMADearrayed()) {
	runPlugin('qupath.imagej.detect.dearray.TMADearrayerPluginIJ', '{"coreDiameterPixels": 1800.0,  "labelsHorizontal": "1-14",  "labelsVertical": "A-L",  "labelOrder": "Column first",  "densityThreshold": 5,  "boundsScale": 105}');
	return;
}
setColorDeconvolutionStains('{"Name" : "H-DAB default", "Stain 1" : "Hematoxylin", "Values 1" : "0.65111 0.70119 0.29049 ", "Stain 2" : "DAB", "Values 2" : "0.26917 0.56824 0.77759 ", "Background" : " 246 246 246 "}');
selectTMACores();
runPlugin('qupath.imagej.detect.tissue.SimpleTissueDetection2', '{"threshold": 240,  "requestedDownsample": 2.0,  "minAreaPixels": 400.0,  "maxHoleAreaPixels": 500.0,  "darkBackground": false,  "smoothImage": true,  "medianCleanup": true,  "dilateBoundaries": false,  "smoothCoordinates": true,  "excludeOnBoundary": false,  "singleAnnotation": true}');
selectAnnotations();
runPlugin(
    'qupath.imagej.detect.nuclei.PositiveCellDetection', 
    '{"detectionImageBrightfield": "Hematoxylin OD",  "backgroundRadius": 15.0,  "medianRadius": 0.0,  "sigma": 3.0,  "minArea": 10.0,  "maxArea": 1000.0,  "threshold": 0.2,  "maxBackground": 2.0,  "watershedPostProcess": true,  "excludeDAB": false,  "cellExpansion": 5.0,  "includeNuclei": true,  "smoothBoundaries": true,  "makeMeasurements": true,  "thresholdCompartment": "Cell: DAB OD mean",  "thresholdPositive1": 0.34,  "thresholdPositive2": 0.4,  "thresholdPositive3": 0.6,  "singleThreshold": true}');

