var CACHED_MAP;function getIconMap(){if(!CACHED_MAP){var e=window;e.Ionicons=e.Ionicons||{},CACHED_MAP=e.Ionicons.map=e.Ionicons.map||new Map}return CACHED_MAP}function addIcons(e){var t=getIconMap();Object.keys(e).forEach(function(o){t.set(o,e[o])})}function getName(e,t,o,n){return t="ios"===(t=(t||"md").toLowerCase())?"ios":"md",o&&"ios"===t?e=o.toLowerCase():n&&"md"===t?e=n.toLowerCase():e&&(e=e.toLowerCase(),/^md-|^ios-|^logo-/.test(e)||(e=t+"-"+e)),"string"!=typeof e||""===e.trim()?null:""!==e.replace(/[a-z]|-|\d/gi,"")?null:e}function getSrc(e){return"string"==typeof e&&isSrc(e=e.trim())?e:null}function isSrc(e){return e.length>0&&/(\/|\.)/.test(e)}function isValid(e){if(1===e.nodeType){if("script"===e.nodeName.toLowerCase())return!1;for(var t=0;t<e.attributes.length;t++){var o=e.attributes[t].value;if("string"==typeof o&&0===o.toLowerCase().indexOf("on"))return!1}for(t=0;t<e.childNodes.length;t++)if(!isValid(e.childNodes[t]))return!1}return!0}export{getName as a,isSrc as b,getSrc as c,getIconMap as d,isValid as e,addIcons as f};