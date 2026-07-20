import urllib.request
import re

url = "https://developer.android.com/jetpack/androidx/releases/navigation"
req = urllib.request.Request(url, headers={'User-Agent': 'Mozilla/5.0'})
try:
    with urllib.request.urlopen(req) as response:
        html = response.read().decode('utf-8')
        versions = re.findall(r'Navigation Version (\d+\.\d+\.\d+)', html)
        if versions:
            print("Latest stable:", versions[0])
            print("implementation(\"androidx.navigation:navigation-fragment-ktx:" + versions[0] + "\")")
            print("implementation(\"androidx.navigation:navigation-ui-ktx:" + versions[0] + "\")")
        else:
            print("Could not parse version")
except Exception as e:
    print(e)
