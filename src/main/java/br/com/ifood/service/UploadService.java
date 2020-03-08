package br.com.ifood.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UploadService {

  @Value("${disco.raiz}")
  private String pathRoot;

  @Value("${disco.diretorio}")
  private String  photoDirectory;

  public void savePhoto(MultipartFile photo) {
    this.save(this.photoDirectory, photo);
  }

  public void save(String diretorio, MultipartFile file) {
    Path diretorioPath = Paths.get(this.pathRoot, diretorio);
    Path arquivoPath = diretorioPath.resolve(file.getOriginalFilename());
    try {
      Files.createDirectories(diretorioPath);
      file.transferTo(arquivoPath.toFile());
    } catch (IOException e) {
      throw new RuntimeException("Erro ao salvar a Foto", e);
    }
  }
}
