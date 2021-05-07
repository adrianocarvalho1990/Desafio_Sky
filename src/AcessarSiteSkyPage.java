import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AcessarSiteSkyPage {
	
	private static final String URL_LOGIN = "http://www.sky.com.br";
	private WebDriver driver;
	
	public AcessarSiteSkyPage() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		this.driver = new ChromeDriver();
		driver.manage().window().maximize();
		this.driver.navigate().to(URL_LOGIN);
	}

	public void fechar() {
		this.driver.quit();
	}
	
	public void paginaInicialSky() {
		driver.findElement(By.className("sky_icon sky_icon-close icon_xs")).click();
	}

	public boolean contemTexto(String texto) {
		return driver.getPageSource().contains(texto);
	}
	
	public void acessarProgramacao() {
		driver.findElement(By.xpath("//a[text()='Programação']")).click();
	}

	public boolean isPaginaProgramacao() {
		return driver.getCurrentUrl().equals("https://www.sky.com.br/programacao");
	}
	
	public void listaDeCanais() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 300);");
		driver.findElement(By.xpath("//a[text()='Lista Canais']")).click();
	}

	public void preenchePesquisaDeCanais(String canal) {
		driver.findElement(By.className("form-control input-search")).sendKeys(canal);
	}
	
	public String getCanalEncontrado() {
		try {
			return driver.findElement(By.xpath("//a[text()='BANDSPORTS HD']")).getText();
		} catch (NoSuchElementException e) {
			return null;
		}
	}
	
}
